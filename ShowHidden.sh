# Need to add permission to run in .sh 
# chmod +x ShowHidden.sh

# Run the file by running this in terminal
# ./ShowHidden.sh

echo "This is the file to show the Hidden File"

while true
do
 read -r -p "Show the Hidden File: [Y/n] " input
 
 case $input in
     [yY][eE][sS]|[yY])
 echo "Yes"
 defaults write com.apple.finder AppleShowAllFiles YES
 killall Finder
 break;
 ;;
 
     [nN][oO]|[nN])
 echo "No"
 defaults write com.apple.finder AppleShowAllFiles NO
 killall Finder
 break;
 ;;

     *)
 echo "Invalid input!! Please enter it again!"
 ;;
 esac
done
