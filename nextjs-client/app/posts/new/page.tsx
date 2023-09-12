"use client";
import PostEditor from "@/components/Posts/PostEditor";
import Ruler from "@/components/Ruler";
import saveNewPost from "@/lib/saveNewPost";
import { useRouter, useSearchParams } from "next/navigation";

export default function Page() {
	const router = useRouter();
	const searchParams = useSearchParams();

	const catId = searchParams.get("category");
	const parentId = searchParams.get("replyTo");

	const cancelCreation = () => {
		router.push("/categories/" + catId);
	};

	const handleNewPost = async (newPost: Post) => {
		const id = await saveNewPost(newPost);
		router.push("/posts/" + id);
	};

	return (
		<>
			<h1 className="text-3xl">Create post</h1>
			<Ruler />
			<PostEditor post={{ id: "", parentId: parentId ? parentId : "", categoryId: catId ? catId : "", isEnabled: false, title: "", body: "", upvoteCount: 0, viewCount: 0 }} handleSave={handleNewPost} cancelAction={cancelCreation} actionTitle="New post" />
		</>
	);
}
