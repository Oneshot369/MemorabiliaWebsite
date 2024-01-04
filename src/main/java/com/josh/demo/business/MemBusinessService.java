package com.josh.demo.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.josh.model.MemModel;

public class MemBusinessService implements MemBusinessServiceInterface{
	
	private List<MemModel> mem = new ArrayList<MemModel>();
	
	public MemBusinessService() {
		initializeOrders();
	}
	private void initializeOrders()
	{
		mem.add(new MemModel(0L, "000", "Darth Vaders Mask", 900000.00f, "It's what the bad guy wore in the star wars movie"));
		mem.add(new MemModel(1L, "001", "Lightsaber", 200000.00f, "goes vummmmmm"));
		mem.add(new MemModel(2L, "002", "Animatronic T-rex", 355000000.00f, "Rawr"));
		mem.add(new MemModel(3L, "003", "Harry Potters Wand", 30000.00f, "Debugus patronus, make this code workus"));
		mem.add(new MemModel(4L, "004", "Kevin chili", 7.99f, "Passes down from Malone to Malone"));
		mem.add(new MemModel(5L, "005", "Mc Lovin's Driver License", 3000.00f, "Official Hawaii Driver license"));
	}
	@Override
	public void test() {
		System.out.println("If you can see this OrdersBusinessService looks like it works");
	}

	@Override
	public List<MemModel> getMem() {
		//then return our list
		return mem;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Movie and Tv Memorabilia";
	}

	public String getSearchTitle(String search) {
		// TODO Auto-generated method stub
		return String.format("Results of Memorabilia with \"%s\" in the name", search);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		System.out.println("Init method of the OrdersBusinessService was called");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy method of the OrdersBusinessService was called");
	}

	@Override
	public List<MemModel> searchMem(String name) {
		
		List<MemModel> results = mem
			.stream()
			.filter(m -> m.getProductName().toLowerCase()
				.contains(name.toLowerCase()))
			.collect(Collectors.toList());

		return results;
	}
	@Override
	public void deleteOne(long id) { 
		for(int i = 0; i < mem.size(); i++){
			if(mem.get(i).getId() == id){
				mem.remove(i);
			}
		}
	}
	@Override
	public MemModel updateOne(MemModel memToUp) {
		long idOfMem = memToUp.getId();

		mem
		.stream().forEach(m ->
		{
			if(m.getId() == idOfMem){
				m.setImg(memToUp.getImg());
				m.setPrice(memToUp.getPrice());
				m.setProductName(memToUp.getProductName());
				m.setDescription(memToUp.getDescription());
			}
		}
		);
		return memToUp;
	}
	@Override
	public long addOne(MemModel memToAdd) {
		// TODO Auto-generated method stub
		mem.add(memToAdd);
		return 1;
	}

}
