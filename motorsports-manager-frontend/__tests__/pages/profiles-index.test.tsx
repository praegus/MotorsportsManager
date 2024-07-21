import { expect, test } from 'vitest'
import { render, screen } from '@testing-library/react'
import Profile from '../../src/pages/profiles/[profileName]/index'
import { vi } from "vitest";

const mockPush = vi.fn();

vi.mock("next/router", () => {
  return {
    useRouter: () => ({
      push: mockPush,
      query: {
        profileName: 'Fin'
      }
    }),
  };
});

test('Profile page', () => {
  render(<Profile />)
  expect(screen.getByTestId('profileGreeter').textContent).toContain('Welcome! Fin')
})