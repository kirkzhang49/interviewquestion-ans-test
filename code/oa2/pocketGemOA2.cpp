#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <iomanip>
#include <locale>
#include <ctime>        
using namespace std;
typedef pair<time_t, string>mypair;
class solution{
private:
	string res;
	double total=0;
	double online=0;
public:
	void process(ifstream & myfile){
		 vector<mypair>status;
		 string line;
		 time_t start, end, mytime, connect, disconnect;
		 bool on = false;


		 while(getline(myfile, line)){
		 	int i = line.find_last_of("::");

		 	mytime = parse(line.substr(1, 19));
		 	string s = line.substr(i+2);
		 	status.push_back({mytime, s});
		 	//cout << put_time(localtime(&mytime), "%T") << '\n';

		 	if(s=="START")start=mytime;
		 	else if(s=="SHUTDOWN"){
		 		end= mytime;
		 		total= difftime(end, start);
		 	}
		 	else if(s== "CONNECTED"){
		 		if(on)continue;
		 		else { connect = mytime; on = true; }
		 	}
		 	else if(s=="DISCONNECTED"){
		 		if(!on)continue;
		 		else { disconnect = mytime; on=false; online+= difftime(disconnect, connect); }
		 		//cout << put_time(localtime(&mytime), "%T") << '\n';
		 	}
		 }

		 if(on)online+= difftime(end, connect);
		 on=false;
	}

	string calculate(){

		if(!total)return "0%";
		double percent= online *100 / total;
		char str[int(percent)];
		sprintf(str, "%.2f", percent);
		return strcat(str, "%");
	}
	time_t parse(string str){
	  	struct tm t;
	    istringstream ss(str);
	    ss.imbue(locale("en_US.utf-8"));
	    ss >> get_time(&t, "%d/%m/%Y-%H:%M:%S");
	    
	    return timelocal(&t);

	}
};
int main(){
	solution s;
	ifstream myfile("test2.txt");
	s.process(myfile);
	 cout << s.calculate();
	return 0;
}