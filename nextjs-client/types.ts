interface Category {
	id: string;
	parentId: string;
	isEnabled: boolean;
	title: string;
	description: string;
	viewCount: number;
}

interface Post {
	id: string;
	parentId: string;
	categoryId: string;
	isEnabled: boolean;
	title: string;
	body: string;
	viewCount: number;
	upvoteCount: number;
}
