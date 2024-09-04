package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Member;
import com.example.demo.dto.User;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@GetMapping("/test01")
	public String test01(Model model) {
		List<String> list1=new ArrayList<>();
		list1.add("개나리");
		list1.add("진달래");
		list1.add("무궁화");
		model.addAttribute("list1",list1);
		
		List<User> list2=new ArrayList<>();
		list2.add(new User("hello","1234"));
		list2.add(new User("java","5678"));
		list2.add(new User("spring","6543"));
		model.addAttribute("list2", list2);
		
		Map<String,String> map=new HashMap<>();
		map.put("name","김자바");
		map.put("email","kim@");
		model.addAttribute("mem",map);
		
		Map<String,User> map1=new HashMap<>() ;
		map1.put("user1",new User("1111", "AAA"));
		map1.put("user2",new User("2222", "BBB"));
		model.addAttribute("map1",map1);
		return "sample/test01";
	}
	@GetMapping("/test02Date")
	public String date(Model model) {
		model.addAttribute("date1",new Date());
		model.addAttribute("date2",LocalDateTime.now());
		return "sample/test02Date";
	}
	
	@GetMapping("/link1")
	public String link1(@RequestParam("id")String id,@RequestParam("pwd")String pwd) {
		System.out.println("id:" + id);
		System.out.println("pwd:" + pwd);
		return "home";
	}
	// href="/sample/link/aaa/1234"
	@GetMapping("/link2/{id}/{pwd}")
	public String link2(@PathVariable("id")String id,@PathVariable("pwd")String pwd) {
		System.out.println("id:" + id +",pwd:" + pwd);
		return "sample/result";
	}
	@GetMapping("/form")  //   sample/form
	public void form(Model model) {
		Member m=new Member("test","1234","test@test.com", true);
		model.addAttribute("mem", m);
	}
	@GetMapping("/formOk")
	public void formOk(@ModelAttribute Member m) {
		System.out.println("formOk....==>" + m);
	}

	
}

























