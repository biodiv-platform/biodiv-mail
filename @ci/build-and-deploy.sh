# Download maven-toolbox
curl -L http://bit.ly/maven-toolbox | bash
chmod +x @ci/maven-toolbox

# Configure and build project
./@ci/maven-toolbox configure-properties src/main/resources/config.properties
./@ci/maven-toolbox configure-m2
./@ci/maven-toolbox configure-hibernate
./@ci/maven-toolbox configure-pre-sdk
mvn clean install
./@ci/maven-toolbox configure-sdk

# Fix CVE-2022-42889: Inject commons-text 1.13.0 and upgrade javadoc plugin after maven-toolbox
sed -i 's|<version>3.3.2</version>|<version>3.8.0</version>|g' target/sdk/pom.xml
sed -i '/<\/properties>/a\\n    <dependencyManagement>\n        <dependencies>\n            <dependency>\n                <groupId>org.apache.commons</groupId>\n                <artifactId>commons-text</artifactId>\n                <version>1.13.0</version>\n            </dependency>\n        </dependencies>\n    </dependencyManagement>' target/sdk/pom.xml

mvn -f target/sdk/pom.xml deploy
