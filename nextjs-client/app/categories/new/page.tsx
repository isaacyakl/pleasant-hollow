"use client";
import CategoryEditor from "@/components/Categories/CategoryEditor";
import Ruler from "@/components/Ruler";
import { useRouter } from "next/navigation";

export default function Page() {
	const router = useRouter();

	const saveNewCategory = async (category: Category) => {
		const res = await fetch("http://localhost:8082/api/v1/categories", {
			method: "POST",
			headers: { "content-type": "application/json" },
			body: JSON.stringify({
				parentId: category.parentId,
				isEnabled: category.isEnabled,
				title: category.title,
				description: category.description,
			}),
		});
		if (!res.ok) {
			throw new Error("Failed to create category");
		}
		router.push("/categories/" + (await res.json()).id);
	};

	const cancelCreation = () => {
		router.push("/");
	};

	return (
		<>
			<h1 className="text-3xl">Create category</h1>
			<Ruler />
			<CategoryEditor category={{ id: "", parentId: "", isEnabled: false, title: "", description: "", viewCount: 0 }} handleSave={saveNewCategory} cancelAction={cancelCreation} actionTitle="New category" />
		</>
	);
}
