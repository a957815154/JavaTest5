echo "1 login"
curl -X POST --header "Content-Type: application/json" --header "Accept: */*" "http://192.168.99.100:8080/customer/login?username=MARY&password=SMITH"
echo ""


echo "2 page"
curl -X GET --header "Accept: */*" "http://192.168.99.100:8080/film/?page=1&pageSize=3&sort=DESC"
echo ""

echo "3 insert"
curl -X PUT --header "Content-Type: application/json" --header "Accept: */*" "http://192.168.99.100:8080/customer/?first_name=cc&last_name=cc&email=cc&address=47%20MySakila%20Drive"
echo -e ""

echo "4 update"
curl -X POST --header "Content-Type: application/json" --header "Accept: */*" -d "{
  \"active\": true,
  \"addressId\": 1,
  \"createDate\": \"2018-08-13T14:37:37.321Z\",
  \"customerId\": 600,
  \"email\": \"string\",
  \"firstName\": \"string\",
  \"lastName\": \"string\",
  \"lastUpdate\": \"2018-08-13T14:37:37.321Z\",
  \"storeId\": \"2\"
}" "http://192.168.99.100:8080/customer/"
echo -e ""

echo "5 delete"
curl "http://192.168.99.100:8080/customer/" -v -X DELETE --cookie "id=600"
echo -e ""

echo "-----end-----"