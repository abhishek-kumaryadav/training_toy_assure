package com.increff.assure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppUiController extends AbstractUiController {

	@RequestMapping(value = "/ui/home")
	public ModelAndView home() {
		ModelAndView mavObject = mav("home.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/client")
	public ModelAndView client() {
		ModelAndView mavObject = mav("client.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/product")
	public ModelAndView product() {
		ModelAndView mavObject = mav("product.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/bin")
	public ModelAndView bin() {
		ModelAndView mavObject = mav("bin.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/channel")
	public ModelAndView channel() {
		ModelAndView mavObject = mav("channel.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/order")
	public ModelAndView order() {
		ModelAndView mavObject = mav("order.html");
		return mavObject;
	}

	@RequestMapping(value = "/ui/orderpreview/{orderId}", method = RequestMethod.GET)
	public ModelAndView orderPreview(@PathVariable String orderId) {
		ModelAndView mavObject = mav("order_preview.html");
		mavObject.addObject("orderId", orderId.toString());
		return mavObject;
	}

	@RequestMapping(value = "/ui/listing")
	public ModelAndView listing() {
		ModelAndView mavObject = mav("channel_listing.html");
		return mavObject;
	}
}
