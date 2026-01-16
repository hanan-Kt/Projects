#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
class Pakistan {
private:
    string agency = "ISI";
    int spies = 23043;
    string regime = "PPP";
public:
    string president = "Ayub Khan";
    string prime_minister = "Shehbaz sharif";
    long long population = 257293754;
    int provinces = 4;
    string cheif_marshal = "General Asim Munir";
    void g_spies (const int spies_new) {
        spies = spies + spies_new;
    }
    void g_regime (const string regime_new) {
        regime = regime_new;
    }
    void g_population (const long long population_new) {
        population = population + population_new;
    }
    string r_agency () const {
        return agency;
    }
    int r_spies () const {
        return spies;
    }
    string r_regime () const {
        return regime;
    }
    long long r_population () const {
        return population;
    }
    void database () const {
    cout << "\n***************************************\n";
    cout << "\tDatabase of Pakistan";
    cout << "\n***************************************\n";
    cout << "\tPublic Data:";
    cout << "\nPresident: \t" << president;
    cout << "\nPrime Minister: " << prime_minister;
    cout << "\nChief Marshal: " << cheif_marshal;
    cout << "\nProvinces: \t" << provinces;
    cout << "\nPopulation: \t" << std::fixed << std::setprecision(0) << r_population();
    cout << "\n\tSensitive Information:";
        cout << "\nAgency: \t" << r_agency();
    cout << "\nNext Regime: \t" << r_regime();
    cout << "\nTotal spies: \t" << r_spies();
    cout << "\n***************************************\n";
    }
};
int main () {
    int option, added;
    string regi;
    long long add;
    Pakistan p1;
    p1.database();
    while (true) {
        cout << "\n***************************************\n";
        cout << "\tEdit Information";
        cout << "\n1. Population";
        cout << "\n2. Spies";
        cout << "\n3. Regime";
        cout << "\n4. Show Database ";
        cout << "\n5. Exit\n";
        cout << "\nEnter your choice: ";
        cin >> option;
        if (!cin) {
            cin.clear();
            cin.ignore(10000, '\n');
            cout << "Invalid input.";
        }
        else if (option == 1) {
            cout << "\n Input new number of people: ";
            while (true) {
                cin >> add;
                if (!cin) {
                    cin.clear();
                    cin.ignore(10000, '\n');
                    cout << "\nPlease input a valid number: ";
                }
                else if (add <= 0) {
                    cout << "\nNumber cannot be 0 or negative. Please input a valid number: ";
                }
                else {
                    break;
                }
            }
                p1.g_population(add);
                cout << "\nTotal population: " << p1.r_population();
        }
        else if (option == 2) {
            cout << "\n\tSensitive Information:";
            cout << "\nInput new spies: ";
            while (true) {
                cin >> added;
            if (!cin) {
                cin.clear();
                cin.ignore(10000 , '\n');
                cout << "\nPlease input a valid number: ";
            }
            else if (added <= 0) {
                cout << "\nNumber cannot be smaller or equal to 0.\n";
                cout << "Please input a valid number: ";
            }
            else {
                break;
            }
        }
            p1.g_spies(added);
            cout << "New number of spies are: " << p1.r_spies();
        }
        else if (option == 3) {
            cout << "\n\tSensitive Information:";
            cout << "\nInput new regime: ";
            cin.ignore();
            getline(cin, regi);
            p1.g_regime(regi);
            cout << "\nNew regime: " << p1.r_regime();
        }
        else if (option == 4) {
            p1.database();
        }
        else if (option == 5) {
            cout << "\nExiting Program .....";
            break;
        }
        else {
            cin.clear();
            cin.ignore(10000, '\n');
            cout << "Invalid input.";
        }
    }
    return 0;
}
