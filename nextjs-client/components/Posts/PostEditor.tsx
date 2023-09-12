import { MouseEventHandler, useState } from "react";
import Button from "../Button";

export default function ({ post, handleSave, actionTitle = "Edit post", cancelAction }: { post: Post; handleSave: Function; actionTitle?: string; cancelAction: MouseEventHandler<HTMLButtonElement> }) {
	const [updatedTitle, setUpdatedTitle] = useState(post.title);
	const [updatedIsEnabled, setUpdatedIsEnabled] = useState(post.isEnabled);
	const [updatedBody, setUpdatedBody] = useState(post.body);

	const submitForm = () => {
		handleSave({ ...post, parentId: post.parentId, title: updatedTitle, isEnabled: updatedIsEnabled, body: updatedBody });
	};

	const updateTitle = (e: React.ChangeEvent<HTMLInputElement>) => {
		setUpdatedTitle(e.target.value);
	};
	const updateIsEnabled = (e: React.ChangeEvent<HTMLInputElement>) => {
		setUpdatedIsEnabled(e.target.checked);
	};
	const updateBody = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
		setUpdatedBody(e.target.value);
	};

	return (
		<div className="w-full flex-col p-4 border-solid border-2 border-[#c2a878] text-[#c2a878] rounded overflow-hidden">
			<h3 className="text-2xl font-bold mb-4">{actionTitle}</h3>

			<label className="block w-full">Title</label>
			<input className="mb-4 text-black w-full sm:w-60" type="text" defaultValue={updatedTitle} onChange={updateTitle} />

			<label className="block w-full">Draft</label>
			<input className="mb-4" type="checkbox" defaultChecked={!updatedIsEnabled} onChange={updateIsEnabled} />

			<label className="block w-full">Body</label>
			<textarea className="w-full h-28 mb-4 text-black" defaultValue={updatedBody} onChange={updateBody}></textarea>

			<div className="w-full flex justify-end">
				<Button onClick={submitForm}>Save</Button>
				<Button onClick={cancelAction}>Cancel</Button>
			</div>
		</div>
	);
}
