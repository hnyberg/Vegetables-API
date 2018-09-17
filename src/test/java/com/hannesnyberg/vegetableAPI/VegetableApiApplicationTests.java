package com.hannesnyberg.vegetableAPI;

import static org.junit.Assert.*;

import com.hannesnyberg.vegetableAPI.Controller.VegetableController;
import com.hannesnyberg.vegetableAPI.Model.Vegetable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VegetableApiApplicationTests {

    private String vegetableName = "Test vegetable";

	@Autowired
	private VegetableController controller;

	@Test
	public void contextLoads() throws Exception {
	    assertNotNull(controller);
	}

	@Test
    public void crudOperationsWork() {

        Long vegetablePrice = 100L;
        Long vegetableId = 1L;

        //  Create and insert test vegetable
        Vegetable vegetableResponseAfterInsertion = controller.addNewVegetable(
	            new Vegetable(vegetableName, vegetablePrice));
	    vegetableId = vegetableResponseAfterInsertion.getId();

	    //  Make sure vegetable was inserted
        Vegetable requestedVegetable = controller.getVegetable(vegetableId);
        assertNotNull(requestedVegetable);
        assertEquals(vegetableName, requestedVegetable.getName());

        //  Try modify vegetable
        vegetableName += " 2.0";
        controller.updateVegetable(new Vegetable(vegetableName, vegetablePrice), vegetableId);

        //  Make sure vegetable was updated
        Vegetable updatedVegetable = controller.getVegetable(vegetableId);
        assertNotNull(updatedVegetable);
        assertEquals(vegetableName, updatedVegetable.getName());

        //  Delete vegetable and make sure is deleted
        controller.deleteVegetable(vegetableId);
        Vegetable deletedVegetable = controller.getVegetable(vegetableId);
        assertNull(deletedVegetable);

    }

}
