#!/bin/sh

echo "Scanning all avalible interfaces ..."
function shell_type {
	echo $SHELL
}

function get_interfaces {
	myshell=$(shell_type)

	if [ "$myshell" = "/bin/sh" ]
		then 
			ifconfig -l
			#echo "Mac or Bash Shell"
		else 
			ifconfig -a | sed 's/[ \t].*//;/^\(lo\|\)$/d'
			#echo "None Bash Shell."
			#echo $myshell
	fi
}

get_interfaces

array=$(get_interfaces)


for e in ${array[@]}
	do 
		ifconfig $e up
		echo $e interface is up
	done

echo "All connections are up"
echo "DONE..."