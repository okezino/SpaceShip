package com.mindera.rocketscience.presentation.view.screens

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindera.rocketscience.R
import com.mindera.rocketscience.common.Constants
import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.databinding.ActivityMainBinding
import com.mindera.rocketscience.presentation.view.adapter.LaunchItemAdapter
import com.mindera.rocketscience.presentation.view.adapter.OnLaunchClickListener
import com.mindera.rocketscience.presentation.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnLaunchClickListener {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    private val launchAdapter: LaunchItemAdapter by lazy {
        LaunchItemAdapter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        getNetworkData()
        observeNetworkData()
    }


    private fun getNetworkData() {
        mainActivityViewModel.getCompanyData()
        mainActivityViewModel.getLaunchList()
    }


    private fun observeNetworkData() {
        observeCompanyData()
        observeLaunchListData()
    }

    private fun observeCompanyData() {
        mainActivityViewModel.companyData.observe(this) { resource ->
            when (resource) {

                is Resource.Loading -> {
                    binding.companyProgress.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    with(binding) {
                        val companyInfo = resource.data!!
                        companyProgress.visibility = View.GONE
                        companyDetails.visibility = View.VISIBLE
                        companyDetails.text = getString(
                            R.string.company_detail,
                            companyInfo.name,
                            companyInfo.founder,
                            companyInfo.founded,
                            companyInfo.employees,
                            companyInfo.launch_sites,
                            companyInfo.valuation
                        )
                    }
                }

                is Resource.Error -> {
                    val error = resource.messages
                    binding.companyProgress.visibility = View.GONE
                    binding.companyDetails.visibility = View.VISIBLE
                    binding.companyDetails.text = error


                }

            }
        }
    }

    private fun observeLaunchListData() {
        mainActivityViewModel.launchListData.observe(this) { resource ->
            when (resource) {

                is Resource.Loading -> {
                    binding.launchProgress.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.launchProgress.visibility = View.GONE
                    val launchList = resource.data!!
                    binding.launchList.layoutManager = LinearLayoutManager(this)
                    binding.launchList.adapter = launchAdapter
                    launchAdapter.submitList(launchList)
                }

                is Resource.Error -> {
                    binding.launchProgress.visibility = View.GONE
                    binding.launchDetailsError.visibility = View.VISIBLE
                    binding.launchDetailsError.text = resource.messages
                }

            }
        }
    }



    override fun onItemClick(launchDTOItem: LaunchDTOItem) {
        val wikiLoadUrl = launchDTOItem.links.wikipedia
        val youtubeLoadUrl = launchDTOItem.links.video_link

        val options = arrayOf("Wikipedia", "Youtube")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose the view")
        mBuilder.setSingleChoiceItems(options, -1) { dialogInterface, i ->

            dialogInterface.dismiss()
            if(i == 0 ) {
                launchWebView(wikiLoadUrl)
            } else {
                launchWebView(youtubeLoadUrl)
            }
        }

        mBuilder.setNeutralButton("Cancel") { dialog, which ->
            dialog.cancel()
        }

        val mDialog = mBuilder.create()
        mDialog.show()

    }

    private fun launchWebView(url : String){
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra(Constants.WEB_URL_CONST, url)
        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.filter_menu,  menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_success -> {
                mainActivityViewModel.getLaunchListByLaunchState(true)
                true
            }

            R.id.action_failed -> {
                mainActivityViewModel.getLaunchListByLaunchState(false)
                true
            }

            R.id.year_launch ->{
                showDialog()
                true
            }

            R.id.action_asc -> {
                mainActivityViewModel.sortByAscAndDesc(true)
                true
            }

            R.id.action_desc -> {
                mainActivityViewModel.sortByAscAndDesc(false)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDialog(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Enter Launch Year")
        val input = EditText(this)
        input.setHint("Enter  Year")
        input.inputType = InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            var year = input.text.toString()
            mainActivityViewModel.getLaunchListByYear(year)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }
}
