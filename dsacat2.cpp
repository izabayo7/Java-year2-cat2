#include <iostream>
#include <vector>
using namespace std;

string findMapping(string str){
    string result="";
    if(str.size()<2){
        result+=str;
    }else{

         if(str =="00"){
             result+="+";
             }
         else if(str =="000"){
             result+="!";
             }
         else if(str =="0000"){
             result+=":";
             }
         else if(str =="00000"){
             result+="<";
             }
         else if(str =="000000"){
             result+=">";
             }
         else if(str =="0000000"){
             result+="\"";
             }
         else if(str =="00000000"){
             result+="|";
             }
         else if(str =="000000000"){
             result+="{";
             }
         else if(str =="0000000000"){
             result+="}";
             }
         else if(str =="00000000000"){
             result+=";";
             }
         else if(str =="000000000000"){
             result+="\\";
             }
         else if(str =="0000000000000"){
             result+=",";
             }
         else if(str =="00000000000000"){
             result+="/";
             }
         else if(str =="000000000000000"){
             result+="?";
             }
         else if(str =="11"){
             result+="a";
             }
         else if(str =="111"){
             result+="b";
             }
         else if(str =="1111"){
             result+="c";
             }
         else if(str =="22"){
             result+="d";
             }
         else if(str =="222"){
             result+="e";
             }
         else if(str =="2222"){
             result+="f";
             }
         else if(str =="33"){
             result+="g";
             }
         else if(str =="333"){
             result+="h";
             }
         else if(str =="3333"){
             result+="i";
             }
         else if(str =="44"){
             result+="j";
             }
         else if(str =="444"){
             result+="k";
             }
         else if(str =="4444"){
             result+="l";
             }
         else if(str =="55"){
             result+="m";
             }
         else if(str =="555"){
             result+="n";
             }
         else if(str =="5555"){
             result+="o";
             }
         else if(str =="66"){
             result+="p";
             }
         else if(str =="666"){
             result+="q";
             }
         else if(str =="6666"){
             result+="r";
             }
         else if(str =="77"){
             result+="s";
             }
         else if(str =="777"){
             result+="t";
             }
         else if(str =="7777"){
             result+="u";
             }
         else if(str =="88"){
             result+="v";
             }
         else if(str =="888"){
             result+="w";
             }
         else if(str =="888"){
             result+="x";
             }
         else if(str =="99"){
             result+="y";
             }
         else if(str =="999"){
             result+="z";
             }
         else if(str =="9999"){
             result+=",";
             }
         else if(str =="01"){
             result+=" ";
             }

    }
    return result;
}

int main(){
    string text;
    string space_delimiter = " ";
    cout << "Welcome to this program\nPlease Enter your sequence:";
    getline (cin,text);
    cout << "The output is:\n\n";
    text += space_delimiter;
    vector<string> words{};
    size_t pos = 0;
    while ((pos = text.find(space_delimiter)) != string::npos) {
        words.push_back(text.substr(0, pos));
        text.erase(0, pos + space_delimiter.length());
    }
    for (const auto &str : words) {
        cout << findMapping(str);
    }
    /*
    input: 3 333 222 4444 4444 555 01 888 5555 6666 4444 22 000
    output: 3helln world!
    */
return 0;
}
