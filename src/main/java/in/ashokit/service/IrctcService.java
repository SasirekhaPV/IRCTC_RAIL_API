package in.ashokit.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.IrctcDao;
import in.ashokit.request.PassengerRequest;
import in.ashokit.response.TicketResponse;

@Service
public class IrctcService {

	@Autowired
	private IrctcDao dao;

	public String bookTicket(PassengerRequest request) {
		// logic will be there to book a ticket

		TicketResponse response = new TicketResponse();
		response.setTicketId(123);
		response.setName(request.getName());
		response.setStatus("CONFIRMED");
		response.setCost(545.50);
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJdate(request.getJdate());
		
		Random rand = new Random();
		int nextInt = rand.nextInt(10000);
		response.setPnr("PNR"+nextInt);

		dao.saveTicket(response);
		return response.getPnr();
	}

	public TicketResponse getTicketByPnr(String pnr) {
		return dao.getTicketByPnr(pnr);
	}

	public String updateTicket(TicketResponse ticket) {
		return dao.updateTicket(ticket);
	}

	public String deleteTicket(String pnr) {
		return dao.deleteTicket(pnr);
	}
}
