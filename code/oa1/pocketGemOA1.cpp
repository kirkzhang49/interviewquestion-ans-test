#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <unordered_map>
#include <unordered_set>
using namespace std;
class solution{
private:
	vector<string>res;
	unordered_set<string>visit;
	unordered_map<string, unordered_set<string> >table;
public:
	vector<string> process(ifstream & myfile){
		bool firstline=false;
		string line="", path="";
		string start, end;
		while(getline(myfile, line)){
			if(!firstline){
				int i=line.find_first_of(" ");
				start=line.substr(0, i);
				end=line.substr(i+1);
				firstline=true;
				continue;
			}

			int j=line.find_first_of(":");
			string node=line.substr(0, j-1);
			unordered_set<string> edge=parse(line.substr(j+2));
			if(!table.count(node))table[node]=edge;
			else table[node].insert(edge.begin(), edge.end());
		}

		helper(start, end, path);

		return res;
	}
	unordered_set<string>parse(string str){
		unordered_set<string>edge;
		string substr;
		stringstream ss(str);
		while(getline(ss, substr, ' '))edge.insert(substr);
		return edge;
	}

	void helper(string start, string end, string path){
		visit.insert(start);
		string original=path;
		path+=start;

		if(start == end)res.push_back(path);
		else{
			for(auto  & node: table[start])if(!visit.count(node))helper(node, end, path);
		}
	    path=original;
	    visit.erase(start);
	}
};
int main(){
	ifstream myfile("test.txt");
	solution s;
	vector<string>res=s.process(myfile);
	for(auto str : res){
		cout << str  << endl;
	}

	return 0;
}
