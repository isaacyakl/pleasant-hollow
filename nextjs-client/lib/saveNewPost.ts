const saveNewPost = async (post: Post) => {
	const res = await fetch("http://localhost:8082/api/v1/posts", {
		method: "POST",
		headers: { "content-type": "application/json" },
		body: JSON.stringify({
			parentId: post.parentId,
			categoryId: post.categoryId,
			isEnabled: post.isEnabled,
			title: post.title,
			body: post.body,
		}),
	});
	if (!res.ok) {
		throw new Error("Failed to create post");
	}
	return await (
		await res.json()
	).id;
};

export default saveNewPost;
