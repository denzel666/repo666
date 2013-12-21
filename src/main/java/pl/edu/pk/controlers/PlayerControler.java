package pl.edu.pk.controlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.pk.middle.dao.PlayerDao;
import pl.edu.pk.middle.model.Player;

@Controller
public class PlayerControler {

	@Autowired
	private PlayerDao playerDao;
	
	
	@RequestMapping(value="Player/index.html",method = RequestMethod.GET)
    public ModelAndView showStatus(){
		List<Player> playersList = playerDao.findAll();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("playersList", playersList);
		ModelAndView mav = new ModelAndView("/Player/index", model);
            return mav;
    }
	
	
}
