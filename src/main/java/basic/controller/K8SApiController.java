package basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class K8SApiController {
	
	@GetMapping(value = "/api/status")
	public String k8sApiTest() {
		log.info("");
		return "Status - returned by Pod!!!";
	}
	
	@GetMapping(value = "/api/status2")
	public String k8sApiTest2() {
		return "Status2 - returned by Pod";
	}

	@GetMapping(value = "/api/status3")
	public String k8sApiTest3() {
		return "Status3 - returned by Pod";
	}
	
	@GetMapping(value = "/api/status4")
	public String k8sApiTest4() {
		return "Status4 - returned by Pod";
	}

	@GetMapping(value = "/api/status5")
	public String k8sApiTest5() {
		return "Status5 - returned by Pod";
	}
	
	@GetMapping(value = "/api/status6")
	public String k8sApiTest6() {
		return "Status6 - returned by Pod";
	}
	
	@GetMapping(value = "/api/status7")
	public String k8sApiTest7() {
		return "Status7 - returned by Pod";
	}
	
	@GetMapping(value = "/api/status8")
	public String k8sApiTest8() {
		return "Status8 - returned by Pod";
	}
}
