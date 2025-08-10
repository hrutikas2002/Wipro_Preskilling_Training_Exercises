package com.wipro.functionalinterface;

//Question: Using consumer print current time in Europe/London

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class ConsumerLondonTime 
{
	public static void main(String[] args) {
		Consumer<ZoneId> londonTime = zone -> 
		{
			String time = ZonedDateTime.now(zone).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			System.out.println("Current time in London: " + time);
		};

		londonTime.accept(ZoneId.of("Asia/Kolkata"));
	}
}
