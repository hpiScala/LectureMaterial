name := "public"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "2.3.5",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.3",
  "pl.metastack"    %% "metarx"            % "0.1.6",
  //"org.mariadb.jdbc" %	"mariadb-java-client"	% "1.4.3",
  "mysql"           %  "mysql-connector-java" %	"5.1.38"
)