package com.mapsa.test.test;

import com.mapsa.test.test.creational.abstractFactory.FactoryProducer;
import com.mapsa.test.test.creational.abstractFactory.VehicleAbstractFactory;
import com.mapsa.test.test.creational.builder.StreetMap;
import com.mapsa.test.test.creational.factory.Car;
import com.mapsa.test.test.creational.factory.Vehicle;
import com.mapsa.test.test.creational.factory.VehicleFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init(String message) {
        this.message = message;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Vehicle car = VehicleFactory.createVehicle(VehicleFactory.VehicleTypeEnum.CAR);
        Vehicle motor = VehicleFactory.createVehicle(VehicleFactory.VehicleTypeEnum.MotorCycle);

        init(motor.showVehicleType());




        // Hello
        PrintWriter writer = response.getWriter();
        writer.println("<html>" +
                "<body>");
        writer.println("<h1 style=\"color:#0a5f6e\">Hello Mapsa App</h1>");
        writer.println("<p>this is a hello world app</p>");
        writer.println("<p>this is a message:" + message + " </p>");
        writer.println("</body> " +
                "</html>");


        /*
        VehicleAbstractFactory vehicleAbstractFactory2 = (VehicleAbstractFactory) FactoryProducer.getFactory(FactoryProducer.FactoryName.Vehicle);
        MotorCycle motor2 = (MotorCycle) vehicleAbstractFactory2.createVehicle(VehicleAbstractFactory.VehicleTypeEnum.CAR);
        */

        VehicleAbstractFactory abstractFactory = (VehicleAbstractFactory) FactoryProducer.getFactory(FactoryProducer.FactoryName.Vehicle);
        Car car2 = (Car) abstractFactory.createVehicle(VehicleAbstractFactory.VehicleTypeEnum.CAR);
        String s = car2.showVehicleType();

        StreetMap map = new StreetMap.Builder(new Point(60,60), new Point(50,50))
                .waterColor(Color.RED)
                .lowTrafficColor(Color.black)
                .landColor(Color.CYAN)
                .build();
        // StreetMap streetMap = new StreetMap.Builder(new Point(60,60), new Point(50,50)).build();
    }

    public void destroy() {
    }
}