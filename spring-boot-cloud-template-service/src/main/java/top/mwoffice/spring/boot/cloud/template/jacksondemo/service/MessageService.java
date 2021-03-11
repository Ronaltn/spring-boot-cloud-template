package top.mwoffice.spring.boot.cloud.template.jacksondemo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import top.mwoffice.spring.boot.cloud.template.jacksondemo.data.Message;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {


	public List<Message> getAll();

	public Message get(Long id);

	public Message create(Message message);

	public String loadFile(String filePath) throws FileNotFoundException, IOException ;
	public String saveIntoFile(String filePath) throws IOException ;
}
