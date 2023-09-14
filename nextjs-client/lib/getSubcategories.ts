const getSubcategories = async (id: string) => {
	const res = await fetch(`http://localhost:8082/api/v1/categories/${id}/subcategories`, {
		method: "GET",
	});
	if (!res.ok) {
		throw new Error("Failed to get subcategories");
	}
	return await res.json();
};

export default getSubcategories;
