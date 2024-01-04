package com.josh.demo.business;

import java.util.List;
import com.josh.model.MemModel;

public interface MemBusinessServiceInterface {
	//accessing data
	public List<MemModel> getMem();
	public long addOne(MemModel memToAdd);
	public List<MemModel> searchMem(String name);
	public void deleteOne(long id);
	public MemModel updateOne(MemModel memToUp);
	//getting the title of our list
	public String getTitle();
	public String getSearchTitle(String search);

	public void test();
	public void init();
	public void destroy();
}
