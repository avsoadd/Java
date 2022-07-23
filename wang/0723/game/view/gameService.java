package game.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class gameService {

	String userName;
	@Autowired
	private gameRepository repository;

	public void insertName(String inputName) {
		repository.insertName(inputName);

	}

	public int getTicket(String inputName) {

		return repository.getTicket(inputName);

	}

}
