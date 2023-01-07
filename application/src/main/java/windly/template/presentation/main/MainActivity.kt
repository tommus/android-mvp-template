package windly.template.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import windly.template.R
import windly.template.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

  private lateinit var binding: ActivityMainBinding

  @Inject lateinit var presenter: MainPresenter
  @Inject lateinit var resources: MainResources

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil
      .setContentView(this, R.layout.activity_main)

    binding.hello = resources.hello()

    presenter.attach(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detach()
  }
}
