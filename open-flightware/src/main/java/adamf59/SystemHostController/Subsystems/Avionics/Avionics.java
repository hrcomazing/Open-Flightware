/**
* JAGSAT MISSION 2019
* Written by Adam Frank, with references to contributors at GitHub and Stack Overflow
*  Updates at GitHub.com/adamf59
*/
package adamf59.SystemHostController.Subsystems.Avionics;

import java.util.Scanner;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinAnalog;
import com.pi4j.io.gpio.GpioPinAnalogOutput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import adamf59.Core.Subsystem;
import adamf59.SystemHostController.SystemHost;
import adamf59.SystemHostController.IO.*;
import adamf59.SystemHostController.System.Console;

public class Avionics extends Subsystem {
    Pin pin;
    ESCControl esc;
    GpioPinPwmOutput pwm;
    SerialArduino arduino;
    public Avionics(int id) {
        super("JAGSAT_AVIONICS_SUBSYSTEM", id);
        arduino = new SerialArduino();
    }

    @Override
    public void init() {
        Console.printInfo("Initializing Avionics Subsystem");
        arduino.init();
/*         pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_01);
        pwm = GPIO.getGPIOController().provisionPwmOutputPin(pin);
        
        Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
        Gpio.pwmSetRange(2000);
        Gpio.pwmSetClock(500);
       setPwm(1024);
       Console.printInfo("Set to 1024");
       Scanner scan = new Scanner(System.in);
       String in = scan.next();
       Console.printInfo("Set to 0");
       setPwm(0);
       Scanner scan1 = new Scanner(System.in);
       String in1 = scan.next(); */
       
    }


    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        arduino.sendSerial(in);
            
            
    }

    @Override
    public void executeAlways() {
        
    }
    public void setPwm(int rate){
        pwm.setPwm(rate);
    }
}