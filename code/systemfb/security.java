SSL session establishment
   – client knows what server he is talking to
• optionalcertificatebasedauthenticationofclient – if server requires authentication and non-repudiation
• usessymmetricencryptionwithsessionkeys – safety of public key, efficiency of symmetric
Distributed Systems: Issues and Approaches 39
validate server’s certificate
////clinet to service 
generate random string C
encrypt C with server’s public key encrypted string C
compute F(A,B,C)
use result to generate session keys
decrypt C with server’s Private key compute F(A,B,C)
use result to generate session keys
 subsequent communication encrypted w/symmetric session keys
 /////////make algorith security only service can decrypt it 
 ////middle man in middle change the ceritifcation 
 (Signing a message)
• encrypting a message with private key signs it
– only you could have encrypted it, it must be from you – it has not been tampered with since you wrote it
• encrypting everything w/private key is a bad idea – if use a key too much, someone will eventually crack it – asymmetric encryption is extremely slow
• no need to encrypt whole message w/private key – compute a cryptographic hash of your message
– encrypt the cryptographic hash with your private key – faster and safer than encrypting whole message