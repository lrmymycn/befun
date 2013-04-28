#!/bin/bash

if [ ! -n "$FTP_HOME" ]
then
        FTP_HOME=/var/ftp/pub/befunftp
fi
echo "Change mode of the sub directories ..."
find $FTP_HOME/befun-web -type d -exec chmod 777 {} \;
echo "Changed!"

echo "Change mode of the files ..."
find $FTP_HOME/befun-web -type f -exec chmod 666 {} \;
echo "Changed!"
