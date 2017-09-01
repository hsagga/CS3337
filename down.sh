
echo "Scanning all avalible interfaces ..."

function get_interfaces {
	ifconfig -l
}

array=$(get_interfaces)


for e in ${array[@]}
	do 
		ifconfig $e down
		echo $e interface is down
	done
		
echo "All connections are down"				
echo "DONE..."