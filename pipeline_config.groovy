jte {
  pipeline_template = "Java"
}

libraries {
  maven {
    mavenId = "maven"
  }
  
  whitesource {
    Product 	= "WhiteSource_Test"
    Project 	= "Test_jenkins"
  }
}
