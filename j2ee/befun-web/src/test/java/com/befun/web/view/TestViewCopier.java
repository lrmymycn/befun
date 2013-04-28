package com.befun.web.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.befun.domain.estate.Apartment;
import com.befun.domain.estate.Floorplan;

public class TestViewCopier {

    @Test
    public void testCopyApartment() {
        Apartment ap = new Apartment();
        Floorplan fp = new Floorplan();
        long fpId = 3l;
        String fpDesc = "fp desc";
        fp.setId(fpId);
        fp.setDescription(fpDesc);
        ap.setFloorplan(fp);
        long apId = 1l;
        String apBid = "ap bid";
        ap.setId(apId);
        ap.setBid(apBid);

        ApartmentView apView = new ApartmentView(ap);
        ViewCopier.copyApartmentToView(ap, apView);
        assertTrue(apId == apView.getId());
        assertEquals(apBid, apView.getBid());
    }
    
    @Test
    public void testCopyFloorplan() {
        Floorplan fp = new Floorplan();
        long fpId = 3l;
        String fpDesc = "fp desc";
        fp.setId(fpId);
        fp.setDescription(fpDesc);

        FloorplanView fpView = new FloorplanView(fp);
        ViewCopier.copyFloorplanToView(fp, fpView);
        assertTrue(fpId == fpView.getId());
        assertEquals(fpDesc, fpView.getDescription());
    }
}
