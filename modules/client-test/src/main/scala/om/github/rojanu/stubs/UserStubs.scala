package om.github.rojanu.stubs

import com.github.rojanu.ResourceHelper

trait UserStubs extends ResourceHelper {
  val userJson: String = loadFixtureFile("/fixtures/user.json")
}
