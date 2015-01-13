from twilio.rest import TwilioRestClient
 

#Program sends a text through the Twilio website

#Your Account Sid and Auth Token from twilio.com/user/account

account_sid = "ACdc006274a82d6ee084e77b288d070983"
auth_token  = "ed441c4639527178e46889e75f7f7202"
client = TwilioRestClient(account_sid, auth_token)

#Message to send
message = "test message"


#Sends Text Message
message = client.messages.create(body = message,to="9856307253",from_="9856354216")
print number 




