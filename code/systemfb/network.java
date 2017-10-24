I think we can merge the above with this
Step 1: Request a record

You begin by asking your computer to resolve a hostname, such as visiting 'http://www.google.com' in a web
 browser. The first place your computer looks is its local DNS cache, which stores DNS information that 
 the computer has recently retrieved.
Step 2: Ask the Recursive DNS servers

If the records are not stored locally, your computer queries (or contacts) your ISP's recursive DNS 
servers. These machines perform the legwork of DNS queries on behalf of their customers. The recursive 
DNS servers have their own caches, which they check before continuing with the query.
Step 3: Ask the Root DNS servers

If the recursive DNS servers do not have the record cached, they contact the root nameservers. These 
thirteen nameservers contain pointers for all of the Top-Level Domains (TLDs), such as '.com', '.net' 
and '.org'. If you are looking for 'www.google.com.', the root nameservers look at the TLD for the domain 
- 'www.google.com'- and direct the query to the TLD DNS nameservers responsible for all '.com' pointers.
Step 4: Ask the TLD DNS servers

The TLD DNS servers do not store the DNS records for individual domains; instead, they keep track of
 the authoritative nameservers for all the domains within their TLD. The TLD DNS servers look at the
  next part of the query from right to left - 'www.google.com' - then direct the query to the authoritative
   nameservers for 'google.com'.
Step 5: Ask the Authoritative DNS servers

Authoritative nameservers contain all of the DNS records for a given domain, such as host records 
(which store IP addresses), MX records (which identify nameservers for a domain), and so on. Since 
you are looking for the IP address of 'www.google.com', the recursive server queries the authoritative 
nameservers and asks for the host record for 'www.google.com'.
Step 6: Retrieving the record

The recursive DNS server receives the host record for 'www.google.com' from the authoritative nameservers,
 and stores the record in its local cache. If anyone else requests the host record for 'www.google.com',
  the recursive servers will already have the answer, and will not need to go through the lookup process 
  again until the record expires from cache.
Step 7: The Answer!

Finally, the recursive server gives the host record back to your computer. Your computer stores the record
 in its cache, reads the IP address from the record, then passes this information to the web browser. 
 Your browser then opens a connection to the IP address '72.14.207.99' on port 80 (for HTTP),
 and our webserver passes the web page to your browser, which displays Google.

