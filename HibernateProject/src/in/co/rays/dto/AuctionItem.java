package in.co.rays.dto;

import java.util.Set;

public class AuctionItem {

	private long id;
	private Set bids;
	private String Description;
	private Bid SuccessfulBid = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Bid getSuccessfulBid() {
		return SuccessfulBid;
	}

	public void setSuccessfulBid(Bid successfulBid) {
		SuccessfulBid = successfulBid;
	}

}
