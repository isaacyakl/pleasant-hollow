"use client";
import Button from "@/components/Button";
import PostEditor from "@/components/Posts/PostEditor";
import Ruler from "@/components/Ruler";
import saveNewPost from "@/lib/saveNewPost";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function Page({ params }: { params: { id: string } }) {
	const [post, setPost] = useState<Post>({ id: "", parentId: "", categoryId: "", isEnabled: false, title: "", body: "", viewCount: 0, upvoteCount: 0 });
	const [showReplyEditor, setShowReplyEditor] = useState(false);
	const [showEditor, setShowEditor] = useState(false);
	const router = useRouter();

	useEffect(() => {
		const getPost = async () => {
			const res = await fetch("http://localhost:8082/api/v1/posts/" + params.id, { cache: "no-store" });

			if (!res.ok) {
				throw new Error("Failed to fetch data");
			}

			setPost(await res.json());
		};
		getPost();
	}, []);

	const deletePost = async () => {
		const res = await fetch("http://localhost:8082/api/v1/posts/" + post.id, { method: "DELETE" });

		if (!res.ok) {
			throw new Error("Failed to delete post");
		}

		router.push("/categories/" + post.categoryId);
	};

	const updatePost = async (updatedPost: Post) => {
		const res = await fetch("http://localhost:8082/api/v1/posts/" + post.id, {
			method: "PUT",
			headers: { "content-type": "application/json" },
			body: JSON.stringify({
				title: updatedPost.title,
				isEnabled: updatedPost.isEnabled,
				body: updatedPost.body,
				categoryId: updatedPost.categoryId,
			}),
		});
		if (!res.ok) {
			throw new Error("Failed to update post");
		}
		setShowEditor(false);
		setPost(updatedPost);
	};

	const editPost = () => {
		setShowEditor((current) => !current);
	};

	const cancelPost = () => {
		setShowEditor(false);
	};

	const replyToPost = () => {
		setShowReplyEditor((current) => !current);
	};

	const cancelReply = () => {
		setShowReplyEditor(false);
	};

	const saveReply = async (updatedPost: Post) => {
		const id = saveNewPost(updatedPost);
		setShowReplyEditor(false);
	};

	return (
		<>
			<p className="text-xs">Post</p>
			<h2 className="text-2xl">{post.title}</h2>
			<div className="w-full flex flex-row">
				<Button onClick={editPost}>Edit</Button>
				<Button onClick={deletePost}>Delete</Button>
			</div>
			{showEditor && <PostEditor post={post} handleSave={updatePost} cancelAction={cancelPost} />}
			<Ruler />
			<p className="text-xs">Upvotes: {post.upvoteCount}</p>
			<p className="text-xs">Views: {post.viewCount}</p>
			<p className="text-xs">{post.isEnabled ? "Enabled" : "Disabled"}</p>
			<p className="text-xs">ID: {post.id}</p>
			<p className="text-xs">Category ID: {post.categoryId}</p>
			<p className="text-xs">Reply to: {post.parentId}</p>
			<Ruler />
			<p>{post.body}</p>
			<Ruler />
			<div className="w-full text-center sm:text-right">
				<Button onClick={replyToPost}>Reply</Button>
			</div>
			{showReplyEditor && <PostEditor post={{ id: "", parentId: post.id, categoryId: post.categoryId, isEnabled: false, title: `Re: ${post.title}`, body: "", viewCount: 0, upvoteCount: 0 }} handleSave={saveReply} cancelAction={cancelReply} />}
		</>
	);
}
