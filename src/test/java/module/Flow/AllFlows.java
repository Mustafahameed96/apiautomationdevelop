package module.Flow;

import core.dbConnect.DbConnect_mySql;
import core.general.BaseTest;
import core.general.ReusableMethods;
import module.Validations.*;
import org.testng.annotations.Test;
import requestPayloads.CreateRegistrationPayload;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllFlows extends BaseTest{
    public AllFlows(){}
//    @Test
//    public void createNewEmployee(){
//        System.out.println("TEST CREATE !!!");
//
//        CreateEmployees.sanityFlowCreateEmployees("Maaz", "10", "");
//    }
    String access_token = null;
    String User_data = null;
    String booking_ID = null;
    String [] returned_fromfunction = null;
    String partner_id = null;
    String Booking_confirmation_id = null;
    String operation_Message = null;

    @Test
    public void UserAuthToServiceMarket(){



        access_token =    UserAuth.userAuthToServiceMarket("admin","v3nturedive","SM-IP-CLIENT","password");
        System.out.println(access_token);



    }
    @Test
    public void UserRegistrationToServiceMarket(){

        UserAuthToServiceMarket();
        User_data = CustomerRegistration.userRegistrationToServiceMarket("mariam.hammad@venturedive.com","Mariam","Hammad","test",access_token);
        System.out.println(User_data);


    }
    @Test
    public void UserBookingOnServiceMarket(){


    UserRegistrationToServiceMarket();
    booking_ID = CustomerBooking.userBookingToServiceMarket(User_data,access_token);
        System.out.println(booking_ID);



    }
    @Test
    public void AllocateToPartner(){


    UserBookingOnServiceMarket();
    returned_fromfunction = Allocatedpartners.GetListOfAllocatedPartners(booking_ID,access_token);
    partner_id = returned_fromfunction[0];
    Booking_confirmation_id = returned_fromfunction[1];
    System.out.println(partner_id+" partner_id");
    System.out.println(Booking_confirmation_id + " Booking confirmation Id");
    }
    @Test
    public void AcceptPartnerRequest(){


    AllocateToPartner();
    operation_Message=AcceptRequest.partnerAcceptRequest(Booking_confirmation_id,access_token);
    System.out.println(operation_Message + " : Accepted");
    }
    @Test
    public void RejectPartnerRequest(){


        AllocateToPartner();
        operation_Message=RejectRequest.partnerRejectRequest(Booking_confirmation_id,access_token);
        System.out.println(operation_Message + " : Rejected");
    }
    @Test
    public void CancelPartnerRequest(){


        AllocateToPartner();
        operation_Message=Cancel_Booking.partnercancelrequest(booking_ID,access_token);
        System.out.println(operation_Message + " : Cancelled");
    }
    @Test
    public void ChangeInBookingRequest(){


        AcceptPartnerRequest();
        operation_Message=changeRequest.changeRequest(booking_ID,access_token);
        System.out.println(operation_Message + " : Cancelled");
    }
    @Test
    public void AcceptChangeInBookingRequest(){


        ChangeInBookingRequest();
        operation_Message=acceptChangeRequest.changeRequest(booking_ID,access_token);
        System.out.println(operation_Message + " : Cancelled");
    }
    @Test
    public void RejectChangeInBookingRequest(){


        ChangeInBookingRequest();
        operation_Message=rejectChangeInRequest.changeRequest(booking_ID,access_token);
        System.out.println(operation_Message + " : Request Cancelled");
    }

    @Test
    public void changePartner(){


    AcceptPartnerRequest();
        operation_Message=changeProvider.changeRequest(booking_ID,access_token,partner_id);
        System.out.println(operation_Message + " : Partner Request Cancelled");
    }








}
