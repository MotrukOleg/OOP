package com.OOP.AutoserviceSpring;

import com.OOP.AutoserviceSpring.model.Vehicle;
import com.OOP.AutoserviceSpring.repository.VehicleRepository;
import com.OOP.AutoserviceSpring.service.VehicleService;
import com.OOP.AutoserviceSpring.service.impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNull;

public class VehicleServiceApplicationTests {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;
    private Vehicle testvehicle;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        testvehicle = new Vehicle();
        testvehicle.setBrand("Toyota");
        testvehicle.setModel("Corolla");
        testvehicle.setYear("2021");
        testvehicle.setType("Sedan");
    }

    @Test
    void saveVehicleSuccessfultest(){

        //arrange
        when(vehicleService.saveVehicle(testvehicle)).thenReturn(testvehicle);

        //act
        vehicleService.saveVehicle(testvehicle);

        //assert
        assertEquals(testvehicle, vehicleService.saveVehicle(testvehicle));
    }

    @Test
    void saveVehicleFailTest(){

        //arrange
        when(vehicleService.saveVehicle(testvehicle)).thenReturn(null);

        //act
        vehicleService.saveVehicle(testvehicle);

        //assert
        assertEquals(null, vehicleService.saveVehicle(testvehicle));
    }

    @Test
    void findByNameSuccessfulTest(){

        //arrange
        when(vehicleService.findByBrand("Toyota")).thenReturn(testvehicle);

        //act
        vehicleService.findByBrand("Toyota");

        //assert
        assertEquals(testvehicle, vehicleService.findByBrand("Toyota"));
    }

    @Test
    void findByNameFailTest(){

        //arrange
        when(vehicleService.findByBrand("Toyota")).thenReturn(null);

        //act
        vehicleService.findByBrand("Toyota");

        //assert
        assertNull(null, vehicleService.findByBrand("Toyota"));
    }

    @Test
    void updateVehicleSuccssesfuTest(){

        //arrange
        when(vehicleService.updateVehicle(testvehicle)).thenReturn(testvehicle);

        //act
        vehicleService.updateVehicle(testvehicle);

        //assert
        assertEquals(testvehicle ,  vehicleService.updateVehicle(testvehicle));
    }

    @Test
    void updateVehicleFailTest(){

        //arrange
        when(vehicleService.updateVehicle(testvehicle)).thenReturn(null);

        //act
        vehicleService.updateVehicle(testvehicle);

        //assert
        assertNull(null ,  vehicleService.updateVehicle(testvehicle));
    }

    @Test
    void deleteVehicleSuccessTest(){

        //arrange
        VehicleService vehicleService = Mockito.mock(VehicleService.class);
        doNothing().when(vehicleService).deleteVehicle("Toyota");

        //act
        vehicleService.deleteVehicle("Toyota");

        //assert
        verify(vehicleService, times(1)).deleteVehicle("Toyota");
    }

    @Test
    void deleteVehicleFailTest(){

        //arrange
        String brand = testvehicle.getBrand();
        VehicleService vehicleService = Mockito.mock(VehicleService.class);
        when(vehicleService.findByBrand("Toyota")).thenReturn(null);

        //act
        vehicleService.deleteVehicle(brand);

        //assert
        verify(vehicleService, times(1)).deleteVehicle(brand);
    }

}
