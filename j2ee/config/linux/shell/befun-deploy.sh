#!/bin/bash

$BEFUN_HOME/bin/befun-clean.sh

echo "Deploying latest version..."
cp -R $FTP_HOME/befun-web $TOMCAT_HOME/webapps/
echo "Latest version deployed!"