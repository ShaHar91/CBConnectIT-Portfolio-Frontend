package cbconnectit.portfolio.web.navigation

sealed class Navigation(val route: String) {
    sealed class Screen(route: String): Navigation(route) {
        data object Home : Screen("/") {

        }

        data object Services: Screen("/services") {
            fun getService(id: String) = "$route/$id"
        }

        data object Projects: Screen("/projects") {
            fun getByTagQuery(tagQuery: String) = "$route?$tagQuery"
            fun getProject(id: String) = "$route/?projectId=$id"
        }
    }

    sealed class External(route: String): Navigation(route) {
        data object LinkedIn : Navigation("https://www.linkedin.com/in/christiano-bolla/")
    }
}