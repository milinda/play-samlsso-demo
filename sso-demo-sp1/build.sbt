name := "sso-demo-sp1"

version := "1.0-SNAPSHOT"

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.pac4j" % "play-pac4j_java" % "1.2.1.htrcv1" exclude("com.typesafe.play", "play-jdbc") exclude("com.typesafe.play", "play-cache"),
  "org.pac4j" % "pac4j-saml" % "1.5.1.htrcv1"
)

play.Project.playJavaSettings
