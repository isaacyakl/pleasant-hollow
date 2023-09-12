import { MouseEventHandler, useState } from "react";
import Button from "../Button";

export default function ({ category, handleSave, actionTitle = "Edit category", cancelAction }: { category: Category; handleSave: Function; actionTitle?: string; cancelAction: MouseEventHandler<HTMLButtonElement> }) {
	const [updatedTitle, setUpdatedTitle] = useState(category.title);
	const [updatedIsEnabled, setUpdatedIsEnabled] = useState(category.isEnabled);
	const [updatedDescription, setUpdatedDescription] = useState(category.description);

	const submitForm = () => {
		handleSave({ ...category, title: updatedTitle, isEnabled: updatedIsEnabled, description: updatedDescription });
	};

	const updateTitle = (e: React.ChangeEvent<HTMLInputElement>) => {
		setUpdatedTitle(e.target.value);
	};
	const updateIsEnabled = (e: React.ChangeEvent<HTMLInputElement>) => {
		setUpdatedIsEnabled(e.target.checked);
	};
	const updateDescription = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
		setUpdatedDescription(e.target.value);
	};

	return (
		<div className="w-full flex-col p-4 border-solid border-2 border-[#c2a878] text-[#c2a878] rounded overflow-hidden">
			<h3 className="text-2xl font-bold mb-4">{actionTitle}</h3>

			<label className="block w-full">Title</label>
			<input className="mb-4 text-black w-full sm:w-60" type="text" defaultValue={updatedTitle} onChange={updateTitle} />

			<label className="block w-full">Enabled</label>
			<input className="mb-4" type="checkbox" defaultChecked={updatedIsEnabled} onChange={updateIsEnabled} />

			<label className="block w-full">Description</label>
			<textarea className="w-full h-28 mb-4 text-black" defaultValue={updatedDescription} onChange={updateDescription}></textarea>

			<div className="w-full flex justify-end">
				<Button onClick={submitForm}>Save</Button>
				<Button onClick={cancelAction}>Cancel</Button>
			</div>
		</div>
	);
}
