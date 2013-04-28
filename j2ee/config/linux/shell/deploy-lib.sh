#!/bin/bash

usage()
{
    echo "USAGE: getSessionCount.sh [OPTIONS]"
    echo " OPTIONS:"
    echo "    -f HOST_FILE  newline separated file listing target hosts(required)"
    echo "    -h HOST_NAME  sepecified host"
    echo "    -u USER  user name of dyn/admin"
    echo "    -p PASSWORD  password of dyn/admin"
    echo "    -r PROTOCAL  protocal of dyn/admin, http or https(default)"
    echo "    -t PARAMETER  which statistic want to get, worker(default) or member"
}

DYN_USER="jade.yang"
DYN_PWD="test"
HTTP_PROTOCAL="https"
STATUS_TYPE="worker"
E_NOHOSTFILE=100
E_UNKNOWN_OPTION=1

while getopts "f:h:u:p:r:t:" FLAG
do
    case $FLAG in
        f)  hostfile="$OPTARG" ;;
        h)  hostname="$OPTARG" ;;
        u)  username="$OPTARG" ;;
        p)  password="$OPTARG" ;;
        r)  protocal="$OPTARG" ;;
        t)  statustype="$OPTARG" ;;
        *)  echo "ERROR: unknown option: $FLAG"
            usage
            exit E_UNKNOWN_OPTION
            ;;
    esac
done

if [ ! -n "$hostfile" ] || [ ! -f $hostfile ]
then
    echo "Must provide host list file."
    usage
    exit $E_NOHOSTFILE
fi

if [ ! -n "$username" ]
then
    username=$DYN_USER
fi

if [ ! -n "$password" ]
then
    password=$DYN_PWD
fi

if [ ! -n "$protocal" ]
then
    protocal=$HTTP_PROTOCAL
fi

if [ ! -n "$statustype" ]
then
    statustype=$STATUS_TYPE
fi

perl jkstatus.pl -j $hostfile -u $username -p $password -r $protocal -a $hostname -t $statustype