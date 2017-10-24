#top ten most command word in a file
$ sed -e 's/\s/\n/g' < test.txt | sort | uniq -c | sort -nr | head  -10
#For example, assume that words.txt has the following content:
#Word Frequency
#the day is sunny the the
#the sunny is is
#Your script should output the following, sorted by descending frequency:
#the 4
#is 3
#sunny 2
#day 1

cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
#tr -s: truncate the string with target string, but only remaining one instance (e.g. multiple whitespaces)

#sort: To make the same string successive so that uniq could count the same string fully and correctly.

#uniq -c: uniq is used to filter out the repeated lines which are successive, -c means counting

#sort -r: -r means sorting in descending order

#awk '{ print $2, $1 }': To format the output, see here. awk '{print $2,$1}' use second word first than first
#-F , means chose split
——————————————————————————————————————————————————————————————————————————————————————————————————
#valid phone number 
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt
#10th line in file 
head -n 10 file.txt | tail -n +10
# Read from the file file.txt and print its transposed content to stdout.

# using awk for this purpose
awk '
    {
        for(i=1; i<=NF; i++)
        {   
            if(line[i] == "")
            {
                line[i] = $i
            }
            else
            {
                line[i] = line[i]" "$i
            }
        }
    }
    END{
         for(i=1; i<=NF; i++)
         {
             print line[i]
         }
       }
    ' file.txt