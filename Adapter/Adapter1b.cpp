// Adapter1b.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <list>
#include <iterator>

using namespace std;

class LegacyCar {

public:
    //coords
    double X;
    double Y;

    LegacyCar(double X_input, double Y_input) {
        X = X_input;
        Y = Y_input;
    }

    void Drive(double X1, double Y1) {
        X += X1;
        Y += Y1;
    }

};

class Vehicle {
public:
    LegacyCar* Car;

    Vehicle(LegacyCar* Car_input) {
        Car = Car_input;
    }

    void moveTo(double X2, double Y2) {
        Car->Drive(X2, Y2);
    }
};

class Racetrack {
public:
    list <Vehicle> CarList;
};

int main()
{

}