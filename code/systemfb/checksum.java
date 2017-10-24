A checksum is a small-sized datum from a block of digital data for the purpose of detecting errors which
 may have been introduced during its transmission or storage. It is usually applied to an installation 
 file after it is received from the download server. By themselves, checksums are often used to verify
  data integrity but are not relied upon to verify data authenticity.
  ///
  The simplest checksum algorithm is the so-called longitudinal parity check, which breaks the data into
   "words" with a fixed number n of bits, and then computes the exclusive or (XOR) of all those words. 
   The result is appended to the message as an extra word. To check the integrity of a message, the 
   receiver computes the exclusive or of all its words, including the checksum; if the result is not 
   a word with n zeros, the receiver knows a transmission error occurred.