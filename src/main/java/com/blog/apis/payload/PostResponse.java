package com.blog.apis.payload;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostResponse {
	
	private List<PostDTO> content;
	
	private int pageNumber;
	
	private int pageSize;
	
	private long totalElement;
	
	private int totalPages;
	
	private boolean lastPage;

}
