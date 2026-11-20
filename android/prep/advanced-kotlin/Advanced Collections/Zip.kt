fun main(){
    val titles = listOf("Home","Login","Dashboard")
    val icons = listOf("HomeIcon","LoginIcon","DashboardIcon")
    val combined = titles.zip(icons)

    for((title,icon) incombined ){
        println("$title: $icon")
    }
}